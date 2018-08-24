function bg3() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb("+r+','+g+','+b+")";
}
function getProjectUrl(){
    var curWwwPath = window.document.location.href;
    var pathName =  window.document.location.pathname;
    console.log(pathName);
    var pos = curWwwPath.indexOf(pathName);
    console.log(pos);
    var localhostPaht = curWwwPath.substring(0,pos);
    console.log(localhostPaht);
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    console.log(projectName);
    return localhostPaht+projectName;
}
$(function () {
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/chart/getChartCount",
        "type":"POST",
        "dataType": "json",
        "data":{"type":8},
        success:function(data){
            var datasets = [];
            $.each(data,function (i,v) {
                var set = {};
                set.label=v.product.name;
                set.data=[v.number];
                set.fillColor=bg3();
                set.strokeColor=bg3();
                set.pointColor=bg3();
                set.pointStrokeColor=bg3();
                set.pointHighlightFill=bg3();
                set.pointHighlightStroke=bg3();
                datasets.push(set)
            })
            var areaChartData = {
                labels: ["产品库存报表"],
                datasets: datasets
            };
            //- BAR CHART -
            //-------------
            var barChartCanvas = $("#kucun").get(0).getContext("2d");
            var barChart = new Chart(barChartCanvas);
            var barChartData = areaChartData;
            var barChartOptions = {
                //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
                scaleBeginAtZero: true,
                //Boolean - Whether grid lines are shown across the chart
                scaleShowGridLines: true,
                //String - Colour of the grid lines
                scaleGridLineColor: "rgba(0,0,0,.05)",
                //Number - Width of the grid lines
                scaleGridLineWidth: 1,
                //Boolean - Whether to show horizontal lines (except X axis)
                scaleShowHorizontalLines: true,
                //Boolean - Whether to show vertical lines (except Y axis)
                scaleShowVerticalLines: true,
                //Boolean - If there is a stroke on each bar
                barShowStroke: true,
                //Number - Pixel width of the bar stroke
                barStrokeWidth: 2,
                //Number - Spacing between each of the X value sets
                barValueSpacing: 5,
                //Number - Spacing between data sets within X values
                barDatasetSpacing: 1,
                //Boolean - whether to make the chart responsive
                responsive: true,
                maintainAspectRatio: true
            };

            barChartOptions.datasetFill = false;
            barChart.Bar(barChartData, barChartOptions);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
    $.ajax({
        "url":pjUrl+"/chart/getProductSum",
        "type":"POST",
        "dataType": "json",
        "data":{"type":7},
        success:function(data){
            var pieChartCanvas = $("#jhzhanbi").get(0).getContext("2d");
            var pieChart = new Chart(pieChartCanvas);
            var PieData = [];
            $.each(data,function (i,v) {
                var set = {};
                set.value=v.price;
                set.color=bg3();
                set.highlight=bg3();
                set.label=v.product.name;
                PieData.push(set)
            });
            var pieOptions = {
                //Boolean - Whether we should show a stroke on each segment
                segmentShowStroke: true,
                //String - The colour of each segment stroke
                segmentStrokeColor: "#fff",
                //Number - The width of each segment stroke
                segmentStrokeWidth: 2,
                //Number - The percentage of the chart that we cut out of the middle
                percentageInnerCutout: 50, // This is 0 for Pie charts
                //Number - Amount of animation steps
                animationSteps: 100,
                //String - Animation easing effect
                animationEasing: "easeOutBounce",
                //Boolean - Whether we animate the rotation of the Doughnut
                animateRotate: true,
                //Boolean - Whether we animate scaling the Doughnut from the centre
                animateScale: false,
                //Boolean - whether to make the chart responsive to window resizing
                responsive: true,
                // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                maintainAspectRatio: true,
            };
            //Create pie or douhnut chart
            // You can switch between pie and douhnut using the method below.
            pieChart.Doughnut(PieData, pieOptions);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
    $.ajax({
        "url":pjUrl+"/chart/getProductSum",
        "type":"POST",
        "dataType": "json",
        "data":{"type":8},
        success:function(data){
            debugger
            var pieChartCanvas = $("#chzhanbi").get(0).getContext("2d");
            var pieChart = new Chart(pieChartCanvas);
            var PieData = [];
            $.each(data,function (i,v) {
                var set = {};
                set.value=v.price;
                set.color=bg3();
                set.highlight=bg3();
                set.label=v.product.name;
                PieData.push(set)
            });
            var pieOptions = {
                //Boolean - Whether we should show a stroke on each segment
                segmentShowStroke: true,
                //String - The colour of each segment stroke
                segmentStrokeColor: "#fff",
                //Number - The width of each segment stroke
                segmentStrokeWidth: 2,
                //Number - The percentage of the chart that we cut out of the middle
                percentageInnerCutout: 50, // This is 0 for Pie charts
                //Number - Amount of animation steps
                animationSteps: 100,
                //String - Animation easing effect
                animationEasing: "easeOutBounce",
                //Boolean - Whether we animate the rotation of the Doughnut
                animateRotate: true,
                //Boolean - Whether we animate scaling the Doughnut from the centre
                animateScale: false,
                //Boolean - whether to make the chart responsive to window resizing
                responsive: true,
                // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                maintainAspectRatio: true,
            };
            //Create pie or douhnut chart
            // You can switch between pie and douhnut using the method below.
            pieChart.Doughnut(PieData, pieOptions);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })


    var areaChartData = {
        labels: ["2018-06-01", "2018-06-05", "2018-06-10", "2018-06-15", "2018-06-20", "2018-06-23", "2018-06-28"],
        datasets: [
            {
                label: "钢筋",
                fillColor: "rgba(210, 214, 222, 1)",
                strokeColor: "rgba(210, 214, 222, 1)",
                pointColor: "rgba(210, 214, 222, 1)",
                pointStrokeColor: "#c1c7d1",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "三角铁",
                fillColor: "rgba(60,141,188,0.9)",
                strokeColor: "rgba(60,141,188,0.8)",
                pointColor: "#3b8bba",
                pointStrokeColor: "rgba(60,141,188,1)",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(60,141,188,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };
    var lineChartCanvas = $("#jhLine").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas);
    var lineChartOptions = {
        //Boolean - If we should show the scale at all
        showScale: true,
        //Boolean - Whether grid lines are shown across the chart
        scaleShowGridLines: false,
        //String - Colour of the grid lines
        scaleGridLineColor: "rgba(0,0,0,.05)",
        //Number - Width of the grid lines
        scaleGridLineWidth: 1,
        //Boolean - Whether to show horizontal lines (except X axis)
        scaleShowHorizontalLines: true,
        //Boolean - Whether to show vertical lines (except Y axis)
        scaleShowVerticalLines: true,
        //Boolean - Whether the line is curved between points
        bezierCurve: true,
        //Number - Tension of the bezier curve between points
        bezierCurveTension: 0.3,
        //Boolean - Whether to show a dot for each point
        pointDot: false,
        //Number - Radius of each point dot in pixels
        pointDotRadius: 4,
        //Number - Pixel width of point dot stroke
        pointDotStrokeWidth: 1,
        //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
        pointHitDetectionRadius: 20,
        //Boolean - Whether to show a stroke for datasets
        datasetStroke: true,
        //Number - Pixel width of dataset stroke
        datasetStrokeWidth: 2,
        //Boolean - Whether to fill the dataset with a color
        datasetFill: true,
        //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
        maintainAspectRatio: true,
        //Boolean - whether to make the chart responsive to window resizing
        responsive: true
    };
    lineChartOptions.datasetFill = false;
    lineChart.Line(areaChartData, lineChartOptions);

});
