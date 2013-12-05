// ================================================================
//                       CHEditor 5.0
// ----------------------------------------------------------------
// Author: Na Chang Ho
// Homepage: http://www.chcode.com
// EMail: support@chcode.com
// Copyright (c) 1997-2010 CHSOFT
// ================================================================
var c = null;
var curView = null;
var S1 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��';
var S2 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��';
var S3 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��'; 
var S4 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��';
var S5 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��';
var japan1 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��';
var japan2 = '�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��';

c = S1.split(' ');
var button = [ { alt : "", img : 'input.gif', 	cmd : inputChar },              
               { alt : "", img : 'cancel.gif', 	cmd : popupClose } ];

var oEditor = null;

function init(dialog) {
	oEditor = this;
	oEditor.dialog = dialog;
	
	var dlg = new Dialog(oEditor);
	dlg.showButton(button);
	
	setupEvent();
	dlg.setDialogHeight();
}

function showTable() {
  	var k = 0;
  	var len = c.length;
  	var w = 9;
  	var h = 20;
  	
  	var table = document.createElement('table');
  	table.border = 0;
  	table.cellSpacing = 1;
  	table.cellPadding = 0;
  	table.align = 'center';
  	
  	for(i=0; i < w; i++) {
  		var tr = table.insertRow(i);
    	for(var j = 0; j < h; j++) {
    		var td = tr.insertCell(j);
    		td.className = 'schar';
    		
        	if ( len < k+1) {
        		td.appendChild(document.createTextNode('\u00a0'));
        	}
        	else {
        		td.style.cursor = 'pointer';
        		td.id = k;
        		td.onclick = function() { getchar(this.id); };
        		td.onmouseover = function() { hover(this, true); };
        		td.onmouseout = function() { hover(this, false); };
        		td.appendChild(document.createTextNode(c[k]));
        	}
      		k++;
    	}
  	}

  	var output = document.getElementById('output');
  	if (output.hasChildNodes()) {
  		for (var i=0; i<output.childNodes.length; i++) {
  			output.removeChild(output.firstChild);
  		}
  	}
  	output.appendChild(table);
}

function sp1 () {
	c = S1.split(' ');
	showTable();
}

function sp2 () {
	c = S2.split(' ');
	showTable();
}

function sp3 () {
	c = S3.split(' ');
	showTable();
}

function sp4 () {
	c = S4.split(' ');
	showTable();
}

function sp5 () {
	c = S5.split(' ');
	showTable();
}

function sp6 () {
	c = japan1.split(' ').concat(japan2.split(' '));
	showTable();
}

function hover(obj, val) {
  	obj.style.backgroundColor = val ? "#5579aa" : "#fff";
  	obj.style.color = val ? "#fff" : "#000";
}

function getchar(i) {
  	document.getElementById('fm_input').value = document.getElementById('fm_input').value + c[i];
}

function inputChar() {
	oEditor.insertHtmlPopup(document.getElementById('fm_input').value);
	oEditor.popupWinClose();
}

function popupClose() {
    oEditor.popupWinClose();
}

function setupEvent() {
	var el = document.body.getElementsByTagName('LABEL');
	
	for (var i=0; i < el.length; i++) {
		el[i].className = 'handCursor';
		el[i].style.fontSize = '9pt';
		el[i].style.margin = (i==0) ? '0px 0px 5px 5px' : '0px 0px 5px 0px';
		el[i].onclick = function () {
			document.getElementById(this.id).style.fontWeight = 'bold';
			switch (this.id) {
			case 's1' : sp1(); break;
			case 's2' : sp2(); break;
			case 's3' : sp3(); break;
			case 's4' : sp4(); break;
			case 's5' : sp5(); break;
			default : sp6();
			};
			
			if (curView != this.id) {
				document.getElementById(curView).style.fontWeight = 'normal';
			}
			curView = this.id;
		} ;

	}
	
	if (curView == null) {
		showTable();
		curView = 's1';
		document.getElementById(curView).style.fontWeight = 'bold';
		document.getElementById('output').style.visibility = 'visible';
	}
	
	document.getElementById("fm_input").value = "";
}