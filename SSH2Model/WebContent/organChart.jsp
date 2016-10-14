<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="jQueryPug/jOrgChart-master/jOrgChart-master/example/css/jquery.jOrgChart.css"/>
<script src="js/jQuery.js" type="text/javascript"></script>
<script src="js/jquery.simpleTablelw.js" type="text/javascript"></script>
<script type="text/javascript" src="jQueryPug/jOrgChart-master/jOrgChart-master/jquery.jOrgChart.js"></script>


<script type="text/javascript">
    var jsonobj =
    {
        success : true,
        root : [
                {
                    id : "001",
                    name : "aaa",
                    parent : null
                },
                {
                    id : "002",
                    name : "bbb",
                    parent : "001"
                },
                {
                    id : "003",
                    name : "ccc",
                    parent : "001"
                },
                {
                    id : "004",
                    name : "ddd",
                    parent : "001"
                },
                {
                    id : "005",
                    name : "eee",
                    parent : "002"
                },
                {
                    id : "006",
                    name : "fff",
                    parent : "003"
                }
        ]
    };
     
    var liTree=function (jsonobj)
    {
    	var $testDiv=$("#testul");
    	var root =jsonobj.root;
    	for(var i=0;i<root.length;i++){
    		var ri=root[i];
    		console.log(ri.name);
    		
    		ri.li=$("<li>"+ri.name+"</li>");
    		ri.ul=false;
			if(ri.parent==null){
				
				$testDiv.append(ri.li);
			}  		
    	}
    	
        for ( var j = 0; j < root.length; j++)
        {
        
            for ( var k = 0; k < root.length; k++)
            {
                if (root[j].parent == root[k].id)
                {
            		if(root[k].ul==false){
            			root[k].li.append("<ul></ul>");
            			root[k].ul=true;
            		}
                	root[k].li.find('ul:first').append(root[j].li);   
                    break;
                }
            }
        }
 
        
    	
    	
    	
    }
    var convert = function (jsonobj)
    {
        var result = {};
        for ( var p in jsonobj)
        {
            if (p != 'root')
            {
                result[p] = jsonobj[p];
            }
        }
        result.root = [];
        var root = jsonobj.root;
        for ( var i = 0; i < root.length; i++)
        {
            var ri = root[i];
            ri.text = ri.name;
            for ( var j = 0; j < root.length; j++)
            {
                root[j].leaf = true;
                for ( var k = 0; k < root.length; k++)
                {
                    if (root[k].parent == root[j].id)
                    {
                        root[j].leaf = false;
                        break;
                    }
                }
            }
             
            if (ri.parent != null && ri.parent != 'null')
            {
                for ( var j = 0; j < root.length; j++)
                {
                    var rj = root[j];
                    if (rj.id == ri.parent)
                    {
                        rj.children = !rj.children ? [] : rj.children;
                        rj.children.push (ri);
                        break;
                    }
                }
            }
             
            if (ri.parent == null || ri.parent == 'null')
            {
                result.root.push (ri);
            }
        }
         
        return result;
    }
     
    var result = convert (jsonobj);
	var iTree=function(next){
    $.ajax({			
			type: "post",
			url: "hrm/organChartAction.action",
			data:{
				departId:next
			},
			dataType:'json',
			success:function(data,textstatus){			
			//	$(this).text(d.result);
			//	var t=data.result[2];
			//	$("#p1").text(t);
			$('body').empty();
			 $('body').append("<input type='button' value='next' id='next' float='left'><div id='test' align='center'><ul id='testul' style='display:none'></ul></div>");
			var jsonobj={};
			jsonobj["department"]=data[0];
			jsonobj["root"]=data[1];
				liTree(jsonobj);
				alert(jsonobj["department"]);
				 $("#testul").jOrgChart();
				alert("success in AjaxAction");	
		    	  $('#next').click(function(){
		    		  //  		  $('textul').empty();
		    		    //		  $('.jOrgChart').remove();
		    		    		  next=next+1;
		    		    		  iTree(next);
		    		    	  });
			},
		    complete: function(XMLHttpRequest, textStatus){
		            //HideLoading();
		        },
			error:function(){
				alert("error");
			}				
		});
	}
    console.log (result);

    
  
    $(document).ready(function(){
    //	  liTree(jsonobj);
	var next=0;

    	  iTree(next); 

    	
    	  
    });
</script>
</head>
<body>
<a href="javascript:void(0)">员工管理</a>|<a href="javascript:void(0)">组织结构</a>


</body>
</html>