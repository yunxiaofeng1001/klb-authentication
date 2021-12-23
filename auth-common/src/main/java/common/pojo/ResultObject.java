package common.pojo;

/**
 * @program: klb-authentication
 * @description: resultout object
 * @author: Yunxf
 * @create: 2021-12-22 15:13
 */

public class ResultObject<R> {

    public Integer code;
    public String message;
    public R data;


    public ResultObject() {
    }

    public ResultObject(Integer code, String message, R data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //TODO 这里有待提高,看看枚举怎么用更合适
    public static <R> ResultObject<R> success(String msg) {
        return get(CommonEnum.SUCCESS_CODE.getCode(),msg,null);
    }

    public static <R> ResultObject<R> success(R data){
        return get(CommonEnum.SUCCESS_CODE.getCode(),null,data);
    }

    public static <R> ResultObject<R> get(final int code,final String message,R data){
        return new ResultObject<R>(code,message,data);
    }


}
