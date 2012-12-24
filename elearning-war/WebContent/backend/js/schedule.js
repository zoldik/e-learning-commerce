function init() {
  $('#seance"').draggable( {
    containment: '.table',
    cursor: 'move',
    snap: '.table'
  } );
}

jQuery(document).load(function(){
	init();
});