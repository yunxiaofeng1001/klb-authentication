package common.pojo;

/**
 * @program: klb-authentication
 * @description:
 * @author: Yunxf
 * @create: 2021-12-22 15:36
 */

public enum CommonEnum {


    /**
     * 成功
     */
    SUCCESS_CODE(200,"正确"),
    /**
     * 失败
     */
    ERROR_CODE(500,"错误");

    private int code;

    private String codeMsg;

    CommonEnum(int code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }
}
