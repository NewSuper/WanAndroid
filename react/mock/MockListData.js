export default {
  'get /ds/list': function (req,res) {  //模拟语境，数据返回
     res.json({
       data : [1,2,3,4],
       maxNum: 4
     });
  }
}