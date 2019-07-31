package com.maitianer.starter.core;

/**
 * User: Leo
 * Date: 2018/1/28 下午11:57
 */
public class DomainConstants {

    public final static long DEFAULT_SYSTEM_ADMIN_ID = 1;
    public final static long DEFAULT_SYSTEM_ADMIN_ROLE_ID = 1;

    public final static String DICT_DEFAULT_LABEL = "N/A";

    public final static String DICT_GROUP_COMMON_STATUS = "common_status";
    public final static String DICT_GROUP_MEMBER_STATUS = "member_status";
    public final static String DICT_GROUP_PARAM_GROUP = "param_group";
    public final static String DICT_GROUP_AREA_TYPE = "area_type";
    public final static String DICT_GROUP_DRAFT_CLASS_TYPE = "draft_class_type";
    public final static String DICT_GROUP_DRAFT_STATUS = "draft_status";
    public final static String DICT_GROUP_ORGANIZATION_GRADE = "organization_grade";
    public final static String DICT_GROUP_DRAFT_QUALITY = "draft_quality";
    public final static String DICT_GROUP_EXAMINE_RESULT = "examine_result";
    public final static String DICT_GROUP_SCORE_RULE_TYPE = "score_rule_type";

    public final static int PARAM_GROUP_SYSTEM = 1;
    public final static int PARAM_GROUP_CUSTOM = 9;

    public final static int AREA_TYPE_COUNTRY = 0;
    public final static int AREA_TYPE_PROVINCE = 1;
    public final static int AREA_TYPE_CITY = 2;
    public final static int AREA_TYPE_DISTRICT = 3;

    public final static String SERVER_HOST_PATH = "contribution.maitianer.com";

    public final static Integer CAPTCHA_VALID_TIME = 10; // 10分钟
    public final static String DEFAULT_CAPTCHA = "1234"; // 10分钟

    /**
     * 稿件保存类型
     */
    public static class DraftSaveType {
        public static final Integer SAVE_DRAFT = 1; // 保存
        public static final Integer CONTRIBUTE_DRAFT = 2; // 投稿
    }

    /**
     * 稿件状态
     */
    public static class DraftStatus {
        public static final Integer WAITING_CONTRIBUTE = 1; // 待投
        public static final Integer WAITING_CHECK = 2; // 待审
        public static final Integer NOT_PASS_PRECHECK = 3; // 审核未通过
        public static final Integer PASS_PRECHECK = 4; // 审核通过
        public static final Integer NOT_PASS_FINAL_CHECK = 5; // 未采用
        public static final Integer PASS_FINAL_CHECK = 6; // 已采用
    }

    /**
     * 异常代码
     */
    public static class ExceptionCode {
        public static final Integer GENERAL_EXCEPTION = 5; // 普通异常
    }

    /**
     * 文件类型
     */
    public static class FileType {
        public static final String IMAGE = "image"; // 图片
        public static final String FILE = "file"; // 图片
    }

    /**
     * 结果代码
     */
    public static class ResultDataCode {
        public static final Integer NORMAL = 0; // 正常
        public static final Integer ERROR = 1; // 出错
    }

    /**
     * 成员状态
     */
    public static class MemberStatus {
        public final static Integer PENDING_CHECK = 1; // 待审核
        public final static Integer NOT_PASS_PRECHECK = 2; // 预审未通过
        public final static Integer PASS_PRECHECK = 3; // 预审通过
        public final static Integer NOT_PASS_CHECK = 4; // 审核未通过
        public final static Integer NORMAL = 5; // 正常
        public final static Integer LOCKED = 9; // 冻结
    }

    /**
     * 角色代码
     */
    public static class RoleCode {
        public final static Long SYS_ADMIN = 1L; // 系统管理员
        public final static Long CITY_ADMIN = 2L; // 市管理员
        public final static Long COUNTY_ADMIN = 3L; // 县区管理员
        public final static Long DRAFT_EXAMINER = 4L; // 稿件审核员
        public final static Long CONTRIBUTOR = 5L; // 投稿信息员
    }

    /**
     * 机构级别
     */
    public static class OrganizationGrade {
        public final static Integer COUNTY = 1; // 县区级
        public final static Integer CITY = 2; // 市本级
    }

    /**
     * 稿件质量
     */
    public static class DraftQuality {
        public final static Integer ORDINARY_DRAFT = 1; // 一般稿件
        public final static Integer GOOD_INFO_DRAFT = 2; // 优秀信息稿件
        public final static Integer GOOD_PICTURE_DRAFT = 3; // 优秀图片稿件
    }

    /**
     * 用户审核结果
     */
    public static class CheckResult {
        public final static Integer PASS = 1; // 通过
        public final static Integer NOT_PASS = 2; // 不通过
    }

    /**
     * 稿件审核结果
     */
    public static class ExamineResult {
        public final static Integer PASS = 1; // 通过
        public final static Integer NOT_PASS = 2; // 不通过
    }

    /**
     * 用户角色
     */
    public static class MemberRole {
        public final static String SYS_ADMIN = "sys_admin"; // 系统管理员
        public final static String CITY_ADMIN = "city_admin"; // 市管理员
        public final static String COUNTY_ADMIN = "county_admin"; // 县区管理员
        public final static String DRAFT_EXAMINER = "draft_examiner"; // 稿件审核员
        public final static String CONTRIBUTOR = "contributor"; // 投稿信息员
    }

    /**
     * 用户角色代码
     */
    public static class MemberRoleCode {
        public final static Integer SYS_ADMIN = 1; // 系统管理员
        public final static Integer CITY_ADMIN = 2; // 市管理员
        public final static Integer COUNTY_ADMIN = 3; // 县区管理员
        public final static Integer DRAFT_EXAMINER = 4; // 稿件审核员
        public final static Integer CONTRIBUTOR = 5; // 投稿信息员
    }

    /**
     * 用户角色
     */
    public static class ScoreRuleType {
        public final static Integer GENERAL_SCORE = 1; // 普通积分
        public final static Integer EXTRA_SCORE = 2; // 附加积分
    }

    /**
     * 通用状态
     */
    public static class CommonStatus {
        public final static Integer NORMAL = 1; // 可用
        public final static Integer DISABLED = 9; // 不可用
        public final static Integer LOGIC_DELETED = 1; // 已逻辑删除
        public final static Integer LOGIC_NOT_DELETED = 0; // 未逻辑删除
    }

    /**
     * 稿件类型
     */
    public static class DraftType {
        public final static Integer ORDINARY_DRAFT = 1; // 普通稿件
        public final static Integer MEDIA_USE = 2; // 媒体采用
    }

    /**
     * 排序顺序
     */
    public static class OrderDirection {
        public final static String ASC = "asc"; // 升序
        public final static String DESC = "desc"; // 降序
    }

    /**
     * 统计类型
     */
    public static class StatisticsType {
        public final static Integer MONTH = 1; // 月度统计
        public final static Integer YEAR = 2; // 年度统计
    }

    /**
     * 系统环境
     */
    public static class SystemEnvironment {
        public static final String PROD_ENVIRONMENT = "prod"; // 正式环境
        public static final String DEV_ENVIRONMENT = "dev"; // 开发环境
        public static final String TEST_ENVIRONMENT = "test"; // 测试环境
    }

    /**
     * 稿件分类属性字段
     */
    public static class DraftScoreRuleDataField {
        public static final String WZWATERNEWS = "wzWaterNews"; // 温州水利水利要闻 scoreRuleId: 9
        public static final String WZWATERREPORT = "wzWaterReport"; // 温州水利水利播报 scoreRuleId: 10
        public static final String CHINAWZNEWS = "chinaWzNews"; // 中国温州要闻 scoreRuleId: 16
        public static final String CHINAWZOTHERS = "chinaWzOthers"; // 中国温州其他栏目 scoreRuleId: 17
        public static final String ZHEJIANGWATERNEWS = "zhejiangWaterNews"; // 浙江水利水利要闻 scoreRuleId: 18
        public static final String ZHEJIANGWATERLOCAL = "zhejiangWaterLocal"; // 浙江水利地方水利 scoreRuleId: 19
        public static final String MWRNETWORK = "mwrNetwork"; // 水利部网 scoreRuleId: 20
        public static final String CHINAWATERNETWORK = "chinaWaterNetwork"; // 中国水利网 scoreRuleId: 21
        public static final String GENERALIMAGE = "generalImage"; // 一般图片 scoreRuleId: 11
        public static final String IMPORTANTIAMGE = "importantIamge"; // 重要图片 scoreRuleId: 12
    }

    /**
     * 稿件分类属性字段对应积分规则Id
     */
    public static class DraftScoreRuleId {
        public static final Long WZWATERNEWS = 9L; // 温州水利水利要闻 scoreRuleId: 9
        public static final Long WZWATERREPORT = 10L; // 温州水利水利播报 scoreRuleId: 10
        public static final Long CHINAWZNEWS = 16L; // 中国温州要闻 scoreRuleId: 16
        public static final Long CHINAWZOTHERS = 17L; // 中国温州其他栏目 scoreRuleId: 17
        public static final Long ZHEJIANGWATERNEWS = 18L; // 浙江水利水利要闻 scoreRuleId: 18
        public static final Long ZHEJIANGWATERLOCAL = 19L; // 浙江水利地方水利 scoreRuleId: 19
        public static final Long MWRNETWORK = 20L; // 水利部网 scoreRuleId: 20
        public static final Long CHINAWATERNETWORK = 21L; // 中国水利网 scoreRuleId: 21
        public static final Long GENERALIMAGE = 11L; // 一般图片 scoreRuleId: 11
        public static final Long IMPORTANTIAMGE = 12L; // 重要图片 scoreRuleId: 12
    }

}
