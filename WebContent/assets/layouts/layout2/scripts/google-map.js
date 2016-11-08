// This example adds a search box to a map, using the Google Place Autocomplete
// feature. People can enter geographical searches. The search box will return a
// pick list containing a mix of places and predicted search terms.

// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

function convertToLat(postal_code) {
	var lat = -1; 
	$.ajax({
		async: false, 
		url: "http://maps.googleapis.com/maps/api/geocode/json?address=" + postal_code, 
		success: function(result){
		      lat = result.results[0].geometry.location.lat ; 
		  }
	}); 
  
  return lat; 
}

function convertToLng(postal_code) {
	var long = -1; 
	$.ajax({
		async: false, 
		url: "http://maps.googleapis.com/maps/api/geocode/json?address=" + postal_code, 
		success: function(result){
		      long = result.results[0].geometry.location.lng ; 
		  }
	}); 
	return long; 
}

function initMap(typeOfEvent, mapInfo) {
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 1.355379, lng: 103.867744},
    zoom: 15,
    mapTypeId: 'roadmap'
  });

  // Create the search box and link it to the UI element.
  var input = document.getElementById('pac-input');
  var searchBox = new google.maps.places.SearchBox(input);
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  // FOR USER LOCATION
  var userLocationIcon = './assets/layouts/layout2/img/bluecircle.png';

  // FOR MARKERS & INFO WINDOW
  var infowindow = new google.maps.InfoWindow({map: map});
  var marker, i;
  var icons = {
    fire: {
      icon: './assets/layouts/layout2/img/fire.png'
    },
    haze: {
      icon: './assets/layouts/layout2/img/haze.png'
    },
    shelter: {
      icon: './assets/layouts/layout2/img/shelter.png'
    },
    mask: {
      icon: './assets/layouts/layout2/img/mask.png'
    }
  };
  var hazeLocation = [
    ['Central PSI', 1.35735,103.82],
    ['North PSI', 1.41803, 103.82],
    ['South PSI', 1.29587, 103.82],
    ['East PSI', 1.35735, 103.94],
    ['West PSI', 1.35735,103.7]
  ];
  // TO BE CHANGED
//  var typeOfEvent = 'haze';
  // Format all events except for haze
//  var mapInfo = [
//    ['Bondi Beach', 1.318175, 103.883086],
//    ['Coogee Beach', 1.328174, 103.883086],
//    ['Cronulla Beach', 1.338173, 103.883086],
//    ['Manly Beach', 1.348172, 103.883086],
//    ['Maroubra Beach', 1.358171, 103.883086]
//  ];
  // Format for haze only
//  var mapInfo = [120, 121, 122, 123, 124];

  // FOR SEARCH
  // Bias the SearchBox results towards current map's viewport.
  map.addListener('bounds_changed', function() {
    searchBox.setBounds(map.getBounds());
  });

  var markers = [];
  // Listen for the event fired when the user selects a prediction and retrieve
  // more details for that place.
  searchBox.addListener('places_changed', function() {
    var places = searchBox.getPlaces();

    if (places.length == 0) {
      return;
    }

    // Clear out the old markers.
    markers.forEach(function(marker) {
      marker.setMap(null);
    });
    markers = [];

    // For each place, get the icon, name and location.
    var bounds = new google.maps.LatLngBounds();
    places.forEach(function(place) {
      if (!place.geometry) {
        console.log("Returned place contains no geometry");
        return;
      }
      var icon = {
        url: place.icon,
        size: new google.maps.Size(71, 71),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 34),
        scaledSize: new google.maps.Size(25, 25)
      };

      // Create a marker for each place.
      markers.push(new google.maps.Marker({
        map: map,
        icon: icon,
        title: place.name,
        position: place.geometry.location
      }));

      if (place.geometry.viewport) {
        // Only geocodes have viewport.
        bounds.union(place.geometry.viewport);
      } else {
        bounds.extend(place.geometry.location);
      }
    });
    map.fitBounds(bounds);
  });

  // GET USER LOCATION
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var userLocation = {
        lat: position.coords.latitude,
        lng: position.coords.longitude
      };

      var userMarker = new google.maps.Marker({
        position: userLocation,
        map: map,
        icon: userLocationIcon
      });
        infowindow.setPosition(userLocation);
        infowindow.setContent('You are here.');
        infowindow.open(map, userMarker);
        map.setCenter(userLocation);
    }, function() {
      handleLocationError(true, infowindow, map.getCenter());
    });
  } else {
    // Browser doesn't support Geolocation
    handleLocationError(false, infoWindow, map.getCenter());
  }

  // FOR MARKERS & INFO WINDOW - Create makers from location
  switch(typeOfEvent) {
    case "haze":
        for (i = 0; i < mapInfo.length; i++) {  
          marker = new google.maps.Marker({
            position: new google.maps.LatLng(hazeLocation[i][1], hazeLocation[i][2]),
            icon: icons[typeOfEvent].icon,
            map: map
          });

          // Create info window for each marker
          google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
              var contentString = '<div id="content">'+
              '<div id="siteNotice">'+
              '</div>'+
              '<h4 id="firstHeading" class="firstHeading"><b>' + hazeLocation[i][0] + '</b></h4>'+
              '<div id="bodyContent">'+
              '<h4>' + mapInfo[i] + '</h4>'+
              '</div>'+
              '</div>';
              infowindow.setContent(contentString);
              infowindow.open(map, marker);
            }
          })(marker, i));
        }
        break;
    default:
        for (i = 0; i < mapInfo.length; i++) {  
          marker = new google.maps.Marker({
            position: new google.maps.LatLng(mapInfo[i][1], mapInfo[i][2]),
            icon: icons[typeOfEvent].icon,
            map: map
          });

          // Create info window for each marker
          google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
              infowindow.setContent(mapInfo[i][0]);
              infowindow.open(map, marker);
            }
          })(marker, i));
        }
  }
}