$(function(){
	'use-strict';

	// sidenav control left
	$(".sidenav-control-left").sideNav({

		edge: 'left',
		closeOnClick: false

	});

	// sidenav control right
	$(".sidenav-control-right").sideNav({
		
		edge: 'right',
		closeOnClick: false

	});

	// panel collapse icon
	$(document).on("click",".collapsible-header",function(e){
	    $(this).parent().siblings().find('span i').removeClass('fa-chevron-down')
		$(this).find('span i').toggleClass('fa-chevron-down')
	});

	// slick slider
	$('.slider-slick').slick({
		
		infinite: true,
		speed: 300,
		slidesToShow: 1,
		autoplay: true

	});
	
	// faq collapse icon
	$(document).on("click",".faq-collapsible",function(e){
	    $(this).parent().siblings().find('i').removeClass('fa-minus')
		$(this).find('i').toggleClass('fa-minus')
	});

	// testimonial
	$("#testimonial").owlCarousel({
 		autoPlay: true,
      	slideSpeed : 300,
      	paginationSpeed : 400,
      	singleItem: true,

  	});

	// tabs
	$('ul.tabs').tabs(); 

	// form date picker
	$('.datepicker').pickadate({
	    selectMonths: true, 
	    selectYears: 15
	});

	// form select
	$('select').material_select();
        

});