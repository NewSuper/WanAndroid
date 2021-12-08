export default {
//此页面数据是写死在model层，-----》实际开发中，需要异步加数数据
  namespace: 'listDataOld',  //命名空间
  state: {
    data: [1,2,3],
    maxNum: 3
  },
  reducers: {
    addNewData : function (state) {  //state 指的是更新之前的状态数据
       let maxNum =state.maxNum +1;
       let newArr = [...state.data,maxNum];

       return{  //返回更新后的state对象
          data: newArr,
          maxNum:maxNum
       }
    }
  }
}