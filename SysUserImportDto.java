package org.jeecg.modules.system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelIgnore;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author:
 * @Date: 2022/4/15 10:09
 */
@Data
public class SysUserImportDto implements Serializable {


    /**
     * 真实姓名
     */
    @NotNull(message = "员工姓名不能为空")
    @Size(max = 16,message = "员工姓名不允许超过16个字")
    @Excel(name = "*员工姓名  （必填；不允许超过16个字）")
    private String realname;

    /**
     *
     * 登录账号  使用手机号作为登录账号，手机号暂时无用
     */
    @NotNull(message = "员工账号必须传")
    //@Pattern(regexp = "[a-zA-Z0-9]*([a-zA-Z0-9-_]+@[a-zA-Z0-9]+\\.[a-zA-Z]+){0,1}", message = "员工账号不合法")
    @Size(min = 6, max = 64,message = "员工账号最少6个字且不允许超过64个字")
    @Excel(name = "*员工账号  （必填；由字母、数字或邮箱组成；不能和已存在的员工账号相同；不允许超过64个字）", width = 15)
    private String username;

    @Excel(name = "标签 （非必填；标签不允许超过20个字；不同标签之间用“||”隔开；支持最多选择30个标签）", width = 15)
    private String label;

    @Excel(name = "手机号 （非必填；符合国内手机号规范）", width = 15)
    @Column(length = 11)
    @Pattern(regexp = "^[1]([3-9])[0-9]{9}$", message = "手机号码不合法")
    private String phone;

//    @Excel(name = "所在部门/技能组  （非必填；需要和系统已存在的部门层级完全一致；上下级部门间用‘/’隔开，且从最上级的一级部门开始，例如“消费者事业群/深圳研发部/前端研发组”。若存在属于多个部门的情况，不同部门之间用“||”隔开；支持最多选择9个部门/技能组）", width = 25)
//    private String departs;

    @Excel(name = "所在部门（非必填；需要和系统已存在的部门层级完全一致；上下级部门间用‘/’隔开，且从最上级的一级部门开始，例如“消费者事业群/深圳研发部/前端研发组”。若存在属于多个部门的情况，不同部门之间用“||”隔开；支持最多选择9个部门）", width = 25)
    private String departs;

//    @Excel(name = "集团名称", width = 25)
//    private String groups;

    /**角色*/
    @NotNull(message = "角色不能为空")
    @Excel(name = "*角色  （必填；需要和系统已存在的角色完全一致；不同角色之间用“||”隔开；支持最多选择9个角色）", width = 15)
    private String role;

    @NotNull(message = "坐席开关设置不能为空")
    @Excel(name = "*是否坐席  （必填；是否坐席为是时，后续的坐席工号、坐席类型必填）", width = 15)
    @Pattern(regexp = "是|否", message = "是否坐席内容错误")
    private String agentSwitch;

    @Excel(name = "坐席昵称  （非必填；不允许超过16个字）", width = 15)
    @Size(max = 16,message = "坐席昵称不允许超过16个字")
    private String nick;

    @Excel(name = "工号 （非必填；只能输入纯数字；不允许超过16个字）", width = 15)
    @Pattern(regexp = "^[0-9]+$", message = "工号只能填数字")
    @Size(max = 16,message = "工号不允许超过16个字")
    private String workNo;

    /**
     * 坐席类型
     */
    @Excel(name = "坐席类型  （非必填；只允许填写“文本坐席”或“电话坐席”或“文本坐席+电话坐席”）", width = 15)
    @Pattern(regexp = "文本坐席|电话坐席|文本坐席\\+电话坐席", message = "坐席类型内容错误")
    private String agentType;
    /**
     * 接待类型
     */
    @Excel(name = "接待方式  （非必填；只允许填写“呼入+呼出”或“呼入”）", width = 15)
    @Pattern(regexp = "呼入\\+呼出|呼入", message = "接待方式内容错误")
    private String receptionType;

    /**
     * 服务语种
     */
    @Excel(name = "服务语种（非必填；角色需要具备翻译功能权限，否则不生效；当前可填写的语种：中文简体、中文繁体、英文）", width = 15)
    @Pattern(regexp = "中文简体|中文繁体|英文", message = "导入失败，当前不支持该语种")
    private String langTypes;

    /**
     * 操作类型
     */
    @NotNull(message = "操作类型不能为空")
    @Excel(name = "*操作类型（必填；只有新增和修改；会对企业当前的账号进行校验，若已存在员工账号则无法进行新增，若不存在员工账号则无法修改）", width = 15)
    @Pattern(regexp = "新增|修改", message = "导入失败，操作类型填写错误，请重新填写。")
    private String operateType;


    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * md5密码盐
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;
    private String departIds;
    private String id;
}
