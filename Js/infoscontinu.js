  google.load("feeds", "1");
   function initialize() {
	 
      var feed = new google.feeds.Feed("http://www.france24.com/fr/economie/rss");
	  feed.setNumEntries(20);
	  
	  			
	  feed.load(function(result) {
        if (!result.error) {
          var news = document.getElementById("news");
		  news.innerHTML = "";
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var mot = " ";
			mot=entry.title+" |";
			mot= mot.replace(","," ");
			for(n=0;n<mot.length; n++)
			{
			var affiche = document.createElement("a");
			affiche.setAttribute("style","display: inline;");
			affiche.innerHTML = mot[n];
			affiche.href = entry.link;
			if(n==(mot.length-1)) {
				affiche.innerHTML+=' ';
			}
			
			news.appendChild(affiche); 
			}
			
		  }
		 
         }
      });
    }
    google.setOnLoadCallback(initialize);
