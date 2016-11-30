/**
 * 
 */
package neu.sxc.expression.syntax.operator;

import neu.sxc.expression.syntax.ArgumentsMismatchException;
import neu.sxc.expression.tokens.DataType;
import neu.sxc.expression.tokens.Valuable;

/** 
* @ClassName: EndOperator 
* @Description: 以。。。为结束
* @author chaoqiang.zhou
* @date 2016年11月7日 上午10:22:50 
*  
*/
public class EndOperator extends BinaryOperator {
    public EndOperator() {
        super("END");
    }

    @Override
    protected Object operate(Valuable[] arguments) throws ArgumentsMismatchException {
        Object result = null;
        //TODO:第一个值是变量值
        Valuable a1 = arguments[0];
        //第二个值是表达式的值
        Valuable a2 = arguments[1];
        if (a1.getDataType() == DataType.STRING && a2.getDataType() == DataType.STRING) {
            result = a1.getStringValue().endsWith(a2.getStringValue());
        } else {
            throw new ArgumentsMismatchException(arguments, "<<");
        }
        return result;
    }
}
