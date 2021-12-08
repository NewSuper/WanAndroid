import React from 'react';

class Hello extends React.Component {
  render() {
    return (
      <div>这是我第一个react-demo,name = {this.props.name},内容={this.props.children}</div>
    );
  }
}

export default Hello;

//export default () => {
//  return <div>这是第一个demo</div>;
//}