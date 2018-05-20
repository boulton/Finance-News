 
  google.load("feeds", "1");
   function initialize() {
	 
      var feed = new google.feeds.Feed("http://www.challenges.fr/finance-et-marche/rss.xml");
	  feed.setNumEntries(10);
	  var feed2 = new google.feeds.Feed("http://rss.feedsportal.com/c/499/f/413824/index.rss");
	  feed2.setNumEntries(10);
      var feed3 =  new google.feeds.Feed("http://econoclaste.org.free.fr/dotclear/rss.php");
	  feed3.setNumEntries(5);
	  var feed4 =  new google.feeds.Feed("http://www.lefigaro.fr/rss/figaro_economie.xml");
	  feed4.setNumEntries(10);
	  var feed5 =  new google.feeds.Feed("http://rss.lemonde.fr/c/205/f/3055/index.rss");
	  feed5.setNumEntries(10);
	  var feed6 =  new google.feeds.Feed("http://www.insee.fr/fr/actualites/nouveau.xml.asp");
	  feed5.setNumEntries(10);
	  
	  feed.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont1");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
	
	  feed2.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont2");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre2");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description2");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
	  
	    feed3.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont3");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
	  
	    feed4.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont4");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
	  
	    feed5.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont5");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
	  
	    feed6.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont6");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
	
	feed31.load(function(result) {
        if (!result.error) {
          var container = document.getElementById("Cont31");
          for (var i = 0; i < result.feed.entries.length; i++) 
		  {
            var entry = result.feed.entries[i];
			var post = document.createElement("div");
			post.setAttribute("class","post");
            var div = document.createElement("div");
			div.setAttribute("class", "SousTitre");
			var st = document.createElement("a");
			st.setAttribute("class", "st");
			div.appendChild(st);
            st.appendChild(document.createTextNode(entry.title));
			st.href = entry.link;
            container.appendChild(post);
			post.appendChild(div);
			var description = document.createElement("div");
			description.setAttribute("class", "Description");
			description.innerHTML = entry.content;
			post.appendChild(description);
		  }
		 
        }
      });
		
    }
    google.setOnLoadCallback(initialize);
