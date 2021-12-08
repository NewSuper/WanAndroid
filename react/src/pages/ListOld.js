import React from 'react';
import { connect } from 'dva';

const namespace = "listDataOld";
//修饰符
//说明：第一个回调函数，作用：将page层和model层进行衔接，返回model中的数据
//并且，将返回的数据，绑定到this.props
//接收第二个函数。作用：将定义的函数绑定到this.props中，调用model层中定义的函数
@connect((state)=>{
  return {
    dataList: state[namespace].data,
    maxNum : state[namespace].maxNum
  }
},(dispatch)=>{ //dispatch可调用model层中定义的函数
  return {
    add: function(){
      dispatch({
        type: namespace + "/addNewData"
      });
    }
  }
})

class ListOld extends React.Component {
    //每一个组件都有一个状态，其保存在this.state中，当状态发生变化，react框架会自动调用render方法，重新渲染
     //注意2点： this.state值的设置要在构造函数中完成,要修改this.state的值，需要调用this.setstate完成，不能直接对this.state修改
     render(){
       return(
         <div>
           <ul>
             {
               //获取state中的数据，进行循环
               this.props.dataList.map((value,index)=>{
                 return <li key={index}>{value}</li>//state中的值会根据点击 发生变化，取最新值
               })
             }
           </ul>
           <button onClick={()=>{
              this.props.add();
           }}>点我呀</button>
         </div>
       );
     }
}
export default ListOld;
