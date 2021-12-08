import React from 'react';

class List extends React.Component {
  constructor(props){  //构造参数中必须要props参数
    super(props);  //调用父类构造方法
    this.state = {   //初始化this.state
      dataList:[1,2,3],
      maxNum: 3
    }
  }
  //每一个组件都有一个状态，其保存在this.state中，当状态发生变化，react框架会自动调用render方法，重新渲染
  //注意2点： this.state值的设置要在构造函数中完成,要修改this.state的值，需要调用this.setstate完成，不能直接对this.state修改
  render(){
    return (
      <div>
        <ul>
         {
         //获取state 中的数据，进行循环
         this.state.dataList.map((value,index) => {
           return <li>{value}</li>   //state中的值会根据点击 发生变化，取最新值
         })
         }

        </ul>
        <button onClick={()=>{
        //点击button.执行函数，更新state数据
          let maxNum = this.state.maxNum +1;
          let newAdd = [...this.state.dataList,maxNum];

          this.setState({
            dataList: newAdd,
            maxNum:maxNum
          });
        }}>click</button>
      </div>
    );
  }
}
export default List;