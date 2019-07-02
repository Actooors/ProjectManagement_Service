package com.management.service.impl;

import com.management.dao.UserMapper;
import com.management.model.entity.LeaderInfo;
import com.management.model.entity.User;
import com.management.model.entity.UserBaseInfo;
import com.management.model.entity.UserExample;
import com.management.model.jsonrequestbody.DeleteUserRequest;
import com.management.model.jsonrequestbody.UpdateOrInsertUser;
import com.management.model.jsonrequestbody.UserStatus;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.AllUserInfo;
import com.management.model.ov.resultsetting.ConstCorrespond;
import com.management.service.SuperAdminService;
import com.management.tools.MD5Tool;
import com.management.tools.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: management
 * @description: 系统管理员业务实现
 * @author: xw
 * @create: 2019-05-11 00:17
 */
@Service
@Slf4j
public class SuperAdminServiceImpl implements SuperAdminService {

    @Resource
    private UserMapper userMapper;

    /**
     * @Description: 获取所有用户信息
     * @Param:
     * @Return: Result(UserBaseInfo)
     * @Author: xw
     * @Date: 19-5-10
     */
    public Result getUserInfo(Integer page){
        List<UserBaseInfo> userBaseInfoList = userMapper.selectAllUserInfo((page-1)*10);
        List<UserBaseInfo> resultList = new ArrayList<>();
        try{
            for(UserBaseInfo userBaseInfo : userBaseInfoList){
                String[] identityTypeArray = userBaseInfo.getIdentity().split("\\|");
                String identity = ConstCorrespond
                        .USER_IDENTITY[Integer.parseInt(identityTypeArray[0])];
                int num = identityTypeArray.length;
                for (int i = 1;i<num;i++) {
                    identity  = identity + "," + ConstCorrespond
                            .USER_IDENTITY[Integer.parseInt(identityTypeArray[i])];
                }
                if(userBaseInfo.getLeaderId() != null){
                    UserBaseInfo leader = userMapper.selectUserInfoByUserId(userBaseInfo.getLeaderId());
                    userBaseInfo.setLeaderName(leader.getUserName());
                }else{
                    userBaseInfo.setLeaderName(null);
                }
                resultList.add(userBaseInfo);
            }
            AllUserInfo allUserInfo  = new AllUserInfo();
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andUserIdIsNotNull();
            int userNum = userMapper.countByExample(userExample);
            allUserInfo.setTotalPage(userNum);
            allUserInfo.setUserData(resultList);
            return ResultTool.success(allUserInfo);
        }catch (Exception e){
            return ResultTool.error("操作失败!请联系开发人员!");
        }
    }

    /**
     * @Description: 添加用户信息
     * @Param: UpdateOrInsertUser
     * @Return:
     * @Author: xw
     * @Date: 19-5-10
     */
    public Result insertUser(UpdateOrInsertUser updateOrInsertUser){
        try{
            User user = new User();
            user.setUserId(updateOrInsertUser.getUserId());
            user.setUserName(updateOrInsertUser.getUserName());
            user.setPassword(MD5Tool.getMD5(updateOrInsertUser.getPassword()));
            int num = updateOrInsertUser.getIdentity().size();
            String identity = getIdentity(updateOrInsertUser.getIdentity().get(0));
            for(int i=1; i< num ;i++){
                identity = identity + "|" + getIdentity(updateOrInsertUser.getIdentity().get(i));
            }
            user.setIdentity(identity);
            user.setLeaderId(updateOrInsertUser.getLeader());
            userMapper.insertSelective(user);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("操作失败!请联系开发人员!");
        }
    }

    private String getIdentity(String str){
        String identity = null;
        switch (str){
            case "user": identity = "1";break;
            case "principal": identity = "2";break;
            case "expert": identity = "3";break;
            case "leader": identity = "4";break;
            case "admin": identity = "5";break;
        }
        return identity;
    }

    /**
     * @Description: 修改用户身份
     * @Param: UpdateOrInsertUser
     * @Return:
     * @Author: xw
     * @Date: 19-5-11
     */
    public Result updateUserIdentity(UpdateOrInsertUser updateOrInsertUser){
        try{
            User user = userMapper.selectByPrimaryKey(updateOrInsertUser.getUserId());
            int num = updateOrInsertUser.getIdentity().size();
            String identity = getIdentity(updateOrInsertUser.getIdentity().get(0));
            for(int i=1; i< num ;i++){
                identity = identity + "|" + getIdentity(updateOrInsertUser.getIdentity().get(i));
            }
            user.setIdentity(identity);
//            log.info(updateOrInsertUser.getLeader());
            if(updateOrInsertUser.getLeader() != null) {
                user.setLeaderId(updateOrInsertUser.getLeader());
            }
            userMapper.updateByPrimaryKeySelective(user);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("操作失败!请联系开发人员!");
        }
    }

    /**
     * @Description: 改变用户状态
     * @Param: UserStatus
     * @Return: Result
     * @Author: xw
     * @Date: 19-5-11
     */
    public Result updateUserStatus(UserStatus userStatus){
        try{
            User user = userMapper.selectByPrimaryKey(userStatus.getUserId());
            user.setIsAbleLogin(userStatus.getStatus());
            userMapper.updateByPrimaryKey(user);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("操作失败!请联系开发人员!");
        }
    }

    /**
     * @Description: 批量删除用户
     * @Param: DeleteUserRequest
     * @Return:
     * @Author: xw
     * @Date: 19-5-11
     */
    public Result deleteUser(DeleteUserRequest deleteUserRequest){
        try{
            List<String> userList = deleteUserRequest.getUserId();
            for(String userId : userList){
                userMapper.deleteByPrimaryKey(userId);
            }
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("操作失败!请联系开发人员!");
        }
    }

    /**
     * @Description: 查询所有领导基本信息
     * @Param:
     * @Return:
     * @Author: xw
     * @Date: 19-5-11
     */
    public Result getAllLeaderInfo(){
        try{
            List<LeaderInfo> LeaderList = userMapper.selectLeaderInfoList("4");
            return ResultTool.success(LeaderList);
        }catch (Exception e){
            return ResultTool.error("操作失败!请联系开发人员!");
        }
    }
}
