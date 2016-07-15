

function GenerateTable() {
    //Build an array containing Customer records.
    var customers = new Array();
    customers.push(["Customer Id", "Name"]);
    customers.push([1, "John Hammond"]);
    customers.push([2, "Mudassar Khan"]);
    customers.push([3, "Suzanne Mathews"]);
    customers.push([4, "Robert Schidner"]);

    //Create a HTML Table element.
    var table = document.createElement("TABLE");
    table.border = "1";

    //Get the count of columns.
    var columnCount = customers[0].length;

    //Add the header row.
    var row = table.insertRow(-1);
    for (var i = 0; i < columnCount; i++) {
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = customers[0][i];
        row.appendChild(headerCell);
    }

    //Add the data rows.
    for (var i = 1; i < customers.length; i++) {
        row = table.insertRow(-1);
        for (var j = 0; j < columnCount; j++) {
            var cell = row.insertCell(-1);
            cell.innerHTML = customers[i][j];
        }
    }

    var dvTable = document.getElementById("dvTable");
    dvTable.innerHTML = "";
    dvTable.appendChild(table);
}


//$.getJSON( "http://localhost:9000/api/test?phoneNumber=827364912&pageNumber=1", function( data ) {
//	  var items = [];
//	  $.each( data, function( key, val ) {
//	    items.push( "<li id='" + key + "'>" + val + "</li>" );
//	  });
//	 
//	  $( "<ul/>", {
//	    "class": "my-new-list",
//	    html: items.join( "" )
//	  }).appendTo( "body" );
//	});

//$.getJSON( "http://localhost:9000/api/test?phoneNumber=827364912&pageNumber=1", function( data ) {
//	  var items = [];
//	  $.each( data.combinations, function( data.combinations ) {
//	    items.push( "<li>" + data.combinations + "</li>" );
//	  });
//	 
//	  $( "<ul/>", {
//	    "class": "my-new-list",
//	    html: items.join( "" )
//	  }).appendTo( "body" );
//	});

var myParam = location.search.split('phoneNumber=')[1]
var page = 1
var combinationsNumber

$(document).ready(function() {
	
	getData()
	
} );

function getData(flag){
	
	var url = "http://52.26.150.86:9000/api/test?phoneNumber=" + myParam + "&pageNumber=" + page
	
	$.getJSON( url , function( data ) {
	  var items = [], combinationHTML = "<ul>";
	  combinationsNumber = data.combinationsNumber;
	  $(".totalVal").text("Total combinations:" + combinationsNumber)
	  $.each( data.combinations, function( key, val) {
		  combinationHTML+=( "<li >" + val + " </li><br>" );
	  });
	  combinationHTML += "<ul/>";
	  $( "#Results" ).html(combinationHTML);
	}).fail(function(jqxhr){
		   if(flag === "plus"){
			   page -= 1
		   }else{
			   page += 1
		   }
	});
	
}

function NextPage(){
	
	page += 1
	
	getData("plus")
	
}
function PrevPage(){
	
	page -= 1
	
	getData("minus")
	
}

