function init() {
  $('#seance"').draggable( {
    containment: '.table',
    cursor: 'move',
    snap: '.table'
  } );
}

jQuery.subscribe('ondrop', function(event,data) {
    console.log(data);
    console.log(event);
});

jQuery(document).load(function(){
	init();
});