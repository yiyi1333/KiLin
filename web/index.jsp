<%--
  Created by IntelliJ IDEA.
  User: 徐文茜
  Date: 2022/5/14
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>地图展示</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>
  <style>
    body,
    html,
    #container {
      overflow: hidden;
      width: 100%;
      height: 100%;
      margin: 0;
      font-family: "微软雅黑";
    }
    #result{
      padding: 7px 10px;
      position: fixed;
      top: 10px;
      left: 20px;
      width: 450px;
      background: #fff;
      box-shadow: 0 2px 6px 0 rgba(27, 142, 236, 0.5);
      border-radius: 7px;
      z-index: 99;
    }
    #result input{
      width:130px;
      margin-right:10px;
      height:25px;
      border: 1px solid rgba(27, 142, 236, 0.5);
      border-radius: 5px;
    }
    #result button{
      border: 1px solid rgba(27, 142, 236, 0.5);
      border-radius: 5px;
      background: rgba(27, 142, 236, 0.5);
      color: #fff
    }
    #search_input{
      padding: 7px 10px;
      position: fixed;
      top: 70px;
      left: 20px;
      width: 450px;
      background: #fff;
      box-shadow: 0 2px 6px 0 rgba(27, 142, 236, 0.5);
      border-radius: 7px;
      z-index: 99;
    }
    #search_input input{
      width:310px;
      margin-right:10px;
      height:25px;
      border: 1px solid rgba(27, 142, 236, 0.5);
      border-radius: 5px;
    }
    #search_input button{
      border: 1px solid rgba(27, 142, 236, 0.5);
      border-radius: 5px;
      background: rgba(27, 142, 236, 0.5);
      color: #fff
    }
    /*#search_input select{*/
    /*  width:310px;*/
    /*  margin-right:10px;*/
    /*  height:25px;*/
    /*  border: 1px solid rgba(27, 142, 236, 0.5);*/
    /*  border-radius: 5px;*/
    /*  z-index: 100;*/
    /*  display: none;*/
    /*}*/
  </style>
</head>
<body>
<div id="container"></div>
<%--<div id='result'>--%>
<%--    经度: <input id="lng" type="text"/>--%>
<%--    纬度: <input id="lat" type="text"/>--%>
<%--    <button onclick="theLocation()"/>查询</button>--%>
<%--</div>--%>
<%--<div id="search_input">--%>
<%--    搜索：<input list="resultPanel" id="search" size="20" value="" oninput="searchKeyword()">--%>
<%--    <datalist id="resultPanel">--%>
<%--    </datalist>--%>
<%--    <button onclick="gotoLocation()"/>查询</button>--%>
<%--</div>--%>
<div id="searchResultPanel">
</div>
</body>
</html>
<script>
  var map;
  var position;
  function loadJScript() {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = '//api.map.baidu.com/api?type=webgl&v=2.0&ak=5QUw9TZNwSSvrByMP5DFzFje3N4E6wxU&callback=init';
    document.body.appendChild(script);
    // getPosition();
  }

  function init() {
    map = new BMapGL.Map('container'); // 创建Map实例
    map.setMapStyleV2({
      styleId: '9043e84466e28dee9249d42b84208877'
    })

    var point = new BMapGL.Point(120.17244747206203,30.303170527913508); // 创建点坐标
    var marker = new BMapGL.Marker(point);        // 创建标注
    map.addOverlay(marker);// 将标注添加到地图中
    var myIcon = new BMapGL.Icon("markers.png", new BMapGL.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMapGL.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMapGL.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
      alert("您点击了标注");
    });

    var point = new BMapGL.Point(120.15821597434122,30.297606377275116); // 创建点坐标
    var marker = new BMapGL.Marker(point);        // 创建标注
    map.addOverlay(marker);// 将标注添加到地图中
    var myIcon = new BMapGL.Icon("markers.png", new BMapGL.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMapGL.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMapGL.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
      alert("您点击了标注");
    });

    var point = new BMapGL.Point(120.15991684622975,30.295608435208788); // 创建点坐标
    var marker = new BMapGL.Marker(point);        // 创建标注
    map.addOverlay(marker);// 将标注添加到地图中
    var myIcon = new BMapGL.Icon("markers.png", new BMapGL.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMapGL.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMapGL.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
      alert("您点击了标注");
    });

    var point = new BMapGL.Point(120.17790264464264,30.29648121471498); // 创建点坐标
    var marker = new BMapGL.Marker(point);        // 创建标注
    map.addOverlay(marker);// 将标注添加到地图中
    var myIcon = new BMapGL.Icon("markers.png", new BMapGL.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMapGL.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMapGL.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
      alert("您点击了标注");
    });
    var point = new BMapGL.Point(120.16196448450039,30.292625119919578); // 创建点坐标
    var marker = new BMapGL.Marker(point);        // 创建标注
    map.addOverlay(marker);// 将标注添加到地图中
    var myIcon = new BMapGL.Icon("markers.png", new BMapGL.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMapGL.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMapGL.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
      alert("您点击了标注");
    });
    var point = new BMapGL.Point(120.1685883765905,30.298020603438555); // 创建点坐标
    var marker = new BMapGL.Marker(point);        // 创建标注
    map.addOverlay(marker);// 将标注添加到地图中
    var myIcon = new BMapGL.Icon("markers.png", new BMapGL.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMapGL.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMapGL.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
      alert("您点击了标注");
    });
    var point1 = new BMapGL.Point(120.16012860944237,30.295298148239674);
    map.centerAndZoom(point1, 18);//6.190422023187381)
    map.enableScrollWheelZoom(); // 启用滚轮放大缩小
    map.addEventListener('click', function (e) {
      alert('点击位置经纬度：' + e.latlng.lng + ',' + e.latlng.lat);
    });

  }
  //地址解析
  function arp(){
    var place = document.getElementById('search').value;
    //创建地址解析器
    var MyGeo = new BMapGL.Geocoder();
    //将地址解析显示在地图上，并调整视野
    MyGeo.getPoint(place, function (point){
      {
        if(point){
          map.centerAndZoom(point, 50000);
          map.addOverlay(new BMapGL.Marker(point, {title: place}))
        }else{
          alert('您选择的地址没有解析到结果！');
        }
      }
    }, '杭州市');
  }
  //搜索
  function searchKeyword(){
    var keyword = document.getElementById("search").value;
    var select = document.getElementById("resultPanel");
    select.options.length = 0;
    var options = {
      onSearchComplete: function(results){
        // 判断状态是否正确
        if (local.getStatus() == BMAP_STATUS_SUCCESS){
          for (var i = 0; i < results.getCurrentNumPois(); i ++){
            // s.push(results.getPoi(i).title + ", " + results.getPoi(i).address);
            // s.push('<option value="' + results.getPoi(i).address + '">' + results.getPoi(i).title + ", " + results.getPoi(i).address + '</option>');
            // select.add(new Option(results.getPoi(i).title, results.getPoi(i).address));
            select.appendChild(new Option(results.getPoi(i).title, results.getPoi(i).address));
          }
          // document.getElementById("resultPanel").innerHTML = s.join("<br/>");
        }
      }
    };
    var local = new BMapGL.LocalSearch(map, options);
    local.search(keyword);
  }

  //定位
  function gotoLocation(){
    var search = document.getElementById("search");
    var place = search.value;
    //创建地址解析器实例
    var myGeo = new BMapGL.Geocoder();
    // 将地址解析结果显示在地图上，并调整地图视野
    myGeo.getPoint(place, function(point){
      var min = 1000;
      var index = -1;
      for(var i = 0; i < position.length; i++){
        if(Math.abs(point.lat - position[i].lat) + Math.abs(point.lng - position[i].lon) < min){
          index = i;
          min = Math.abs(point.lat - position[i].lat) + Math.abs(point.lng - position[i].lon);
        }
      }
      var observe = new BMapGL.Point(position[index].lon, position[index].lat);
      if(point){
        map.centerAndZoom(observe, 50000);
        var marker = new BMapGL.Marker(observe, {title: place + '最近观测点'});
        map.addOverlay(marker);
        //图文信息
        var opts = {
          width: 500,
          height: 400,
        }
        var sContent = `<div id="echart" style="height: 100%"></div>`;
        var infoWindow = new BMapGL.InfoWindow(sContent, opts);
        //marker添加点击事件
        marker.addEventListener('click', function (){
          this.openInfoWindow(infoWindow);
          setTimeout(fun, 1000);
        });
      }else{
        alert('您选择的地址没有解析到结果！');
      }
    }, '杭州市');
  }
  //显示echart
  function fun(){
    var myChart = echarts.init(document.getElementById('echart'));
    option = {
      xAxis: {
        type: 'category',
        data: ['PM2.5', 'PM10', 'SO2', 'NO2', 'CO', 'O3']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [20.21, 23.56, 8.65, 4.58, 0.29, 63.44],
          type: 'bar'
        }
      ]
    };
    myChart.setOption(option);
  }
  // 用经纬度设置地图中心点
  function theLocation(){
    if(document.getElementById("lng").value != "" && document.getElementById("lat").value != ""){
      map.clearOverlays();
      var new_point = new BMapGL.Point(document.getElementById("lng").value,document.getElementById("lat").value);
      var marker = new BMapGL.Marker(new_point);  // 创建标注
      map.addOverlay(marker);              // 将标注添加到地图中
      map.panTo(new_point);
    }
  }
  window.onload = loadJScript; // 异步加载地图
  //发送请求请求地址数据；
  function getPosition(){
    document.getElementById('kbgrid_table_0').getElementsByTagName('tbody')[0].innerHTML;
    //创建对象
    const xhr = new XMLHttpRequest();
    //初始化设置方法和参数
    xhr.open('GET', 'http://localhost:8080/DomeSpring_Web_exploded/position');
    //发送
    xhr.send();
    //事件绑定 处理服务端返回的结果
    xhr.onreadystatechange = function (){
      if(xhr.readyState === 4){
        if(xhr.status >= 200 && xhr.status < 300){
          position = JSON.parse(xhr.response);
        }
      }
    }
  }
</script>
