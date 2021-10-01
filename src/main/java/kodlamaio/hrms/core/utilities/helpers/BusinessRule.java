package kodlamaio.hrms.core.utilities.helpers;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

public class BusinessRule {
    public static Result run(Result... results){
        for (var result:results) {
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }
}
