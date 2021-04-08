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

var tags='';
function addTag(event) {
  if (event.keyCode === 13) {       
      var parent = document.getElementById("tag-input");
		 var tag = document.getElementById("tag").value;
		 tags=tag+','+tags;
		document.getElementById("tags").innerHTML=tags;
		document.getElementById("tags").value=tags;


      var parentChild = document.createElement("div");
      parentChild.setAttribute("class", "tag-view");
      parentChild.addEventListener("click", remTag);
      parent.insertBefore(parentChild, document.getElementById("tag"));
      var child1 = document.createElement("span");
      child1.innerHTML = document.getElementById("tag").value;
      var child2 = document.createElement("span");
      child2.setAttribute("class", "material-icons");
      child2.innerHTML = "close";
      child1.style.fontSize="14px";
      child1.style.fontWeight="bold";
      child2.style.fontWeight="bold";
      parentChild.appendChild(child1);
      parentChild.appendChild(child2);
      document.getElementById("tag").value = "";
  }
}

function remTag() {
  var parent = document.getElementById("tag-input");
  var child = this;
  parent.removeChild(child);

}

function navigateToggle(obj){
	var intake=document.getElementById('intake');
	var hpc=document.getElementById('hpc');
	var exam=document.getElementById('exam');
	var diagnosis=document.getElementById('diagnosis');
	var order=document.getElementById('order');
	var planofcare=document.getElementById('planofcare');

	
	
	if(obj=='intake-link')
	{
		intake.style.display="block";
		hpc.style.display="none";
		exam.style.display="none";
		diagnosis.style.display="none";
		order.style.display="none";
		planofcare.style.display="none";
	}
	if(obj=='hpc-link')
	{
		intake.style.display="none";
		hpc.style.display="block";
		exam.style.display="none";
		diagnosis.style.display="none";
		order.style.display="none";
		planofcare.style.display="none";
	}
	if(obj=='exam-link')
	{
		intake.style.display="none";
		hpc.style.display="none";
		exam.style.display="block";
		diagnosis.style.display="none";
		planofcare.style.display="none";
	}
	if(obj=='diagnosis-link')
	{
		intake.style.display="none";
		hpc.style.display="none";
		exam.style.display="none";
		diagnosis.style.display="block";
		planofcare.style.display="none";
	}
	if(obj=='plan-link')
	{
		intake.style.display="none";
		hpc.style.display="none";
		exam.style.display="none";
		diagnosis.style.display="none";
		planofcare.style.display="block";
	}
	
}

$(".text").on("click", function() {
  $(this).css("background", "#F5F1FF");
})
