import request from '../util/request';

export default {
//此页面数据是写死在model层，-----》实际开发中，需要异步加数数据
  namespace: 'listEffect',  //命名空间
  state: {
    data: [],
    maxNum:1
  },
  reducers: {
    addNewData : function (state,result) {  //state 指的是更新之前的状态数据,result代表的是请求到的数据
        if(result.data){  //如果state存在data数据
          return result.data;
        }

       let maxNum =state.maxNum +1;
       let newArr = [...state.data,maxNum];

       return{  //返回更新后的state对象
          data: newArr,
          maxNum:maxNum
       }
    }
  },
  effects: {//新增effects配置，用于异步加载数据
    *initData(params,sagaEffects){//定义异步方法
      const {call,put }  =sagaEffects;//获取call .put 方法
      const url="/ds/list";//定义请求的url
      let data = yield call(request,url);//执行请求
      yield put({//调用reducer的方法
        type : "addNewData",//指定方法名
        data: data  //传递ajax回来的数据
      });
    }
  }
}