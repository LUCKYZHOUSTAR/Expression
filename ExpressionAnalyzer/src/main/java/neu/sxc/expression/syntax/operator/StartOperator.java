/**
 * 
 */
package neu.sxc.expression.syntax.operator;

import neu.sxc.expression.syntax.ArgumentsMismatchException;
import neu.sxc.expression.tokens.DataType;
import neu.sxc.expression.tokens.Valuable;

/** 
* @ClassName: StartOperator 
* @Description: 以。。。为开始
* @author chaoqiang.zhou
* @date 2016年11月4日 下午5:17:02 
*  
*/
public class StartOperator extends BinaryOperator {

    public StartOperator() {
        super("START");
    }

    @Override
    protected Object operate(Valuable[] arguments) throws ArgumentsMismatchException {
        Object result = null;
        //TODO:第一个值是变量值
        Valuable a1 = arguments[0];
        //第二个值是表达式的值
        Valuable a2 = arguments[1];
        if (a1.getDataType() == DataType.STRING && a2.getDataType() == DataType.STRING) {
            result = a1.getStringValue().startsWith(a2.getStringValue());
        } else {
            throw new ArgumentsMismatchException(arguments, ">>");
        }
        return result;
    }
}
