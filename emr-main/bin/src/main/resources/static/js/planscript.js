$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }
});

$('.tab a').on('click', function (e) {
  e.preventDefault();
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  target = $(this).attr('href');
  $('.tab-content > div').not(target).hide();
  $(target).fadeIn(600);
});

var actWidth = $("#summary-bottom").find(".active").parent("td").width();
var actPosition = $("#summary-bottom .active").position();

$(function() {
  $("[name=toggler]").each(function(i) {
      $(this).change(function(){
          $('#blk-1, #blk-2, #blk-3, #blk-4').hide();
          divId = 'blk-' + $(this).val();
          $("#"+divId).show('slow');
      });
  });
});


$(function() {
  $( "#datepicker" ).datepicker();
  });
  

  $(".text").on("click", function() {
    $(this).css("background", "#F5F1FF");
  })
  