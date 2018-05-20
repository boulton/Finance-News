var nom="section_1";
function FocusOn( x)
{
	 
	 var nom ="section_"+x ;
	 var Article= document.getElementById(nom);
	 var nbrArticle = 10;
	  var DimensionArt = 175;
	  var taille = nbrArticle*DimensionArt+"px";
	 Article.style.height = taille;

}
 function fermer(x)
 {
	 var nom ="section_"+x;
	 document.getElementById(nom).style.height = "1px";
 }
 
  
  
 function spoil(y)
 {
	var x=1 ;
	var lecture = document.getElementById( "section_"+y);
	for(x=1; x<7; x++)
	{
		var section = document.getElementById("section_"+x);
		section.style.height = "1px";
	}
	var taille = (document.getElementById("Cont"+y).offsetHeight)+300+"px";
	lecture.style.height= taille ;
	document.getElementById( "centre").style.height = taille ;
 }
 
 function pop()
{
	window.open('graph.html','Graphique bourse',
	'toolbar=0, location=0, directories=0, status=0,scrollbars=0,resizable=0, copyhistory=0, menuBar=0, width=930, height=550'); 
}