jQuery(document).ready(function(jQuery){
   jQuery('#listBatchCheckbox').click(function(){
       jQuery(this).closest('table').find("td input[type='checkbox']").attr('checked', jQuery(this).is(':checked'));
   });
});