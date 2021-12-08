import React from 'react';

class LifeCycle extends React.Component {

    constructor(props){
        super(props);
        console.log("constructor");//构造方法
    }
    componentDidMount(){
            console.log("componentDidMount");//组件挂载后调用
    }
    componentWillUnMount(){
          console.log("componentWillUnMount");//在组件从dom中移除之前立刻被调用
    }
    componentDidUpdate(){
          console.log("componentDidUpdate");//在组件完成更新后立即调用，在初始化不会被 调用
    }
    shouldComponentUpdate(nextProps,nextState){
          console.log("shouldComponentUpdate");//每当this.props或this.state有变化，在render方法执行前，会调用
          //该方法返回一个bool ,表示是否应该继续执行render即如果返回false。 ui 就不会
          //组件挂载时，render方法的第一次执行，不会调用这个方法
    }
    render() {
      return (
        <div>
          <h1>React LifeCycle !</h1>
        </div>
      );
    }

}
export default LifeCycle;