package presenter;

import bean.Result;
import core.DataCall;
import model.CartModel;

public class CartPresenter extends Basepresenter {
    public CartPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getData(Object... args) {
        Result result = CartModel.goodsList();//调用网络请求获取数据
        return result;
    }
}
