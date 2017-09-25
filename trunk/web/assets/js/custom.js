	// -------------------------------------------------------------
	// Shuffle
	// -------------------------------------------------------------

	(function () {
	    $('.nav a').click(function () {
	        //Toggle Class
	        $(".active").removeClass("active");
	        $(this).closest('li').addClass("active");
	        var theClass = $(this).attr("class");
	        $('.' + theClass).parent('li').addClass('active');
	        //Animate
	        $('html, body').stop().animate({
	            scrollTop: $($(this).attr('href')).offset().top - 80
	        }, 400);
	        return false;
	    });
	    $('.scrollTop a').scrollTop();
	}());

	(function () {

	    var $grid = $('#portfolio');

	    $grid.shuffle({
	        itemSelector: '.portfolio-item'
	    });

	    /* reshuffle when user clicks a filter item */
	    $('#filter a').click(function (e) {
	        e.preventDefault();

	        // set active class
	        $('#filter a').removeClass('active');
	        $(this).addClass('active');

	        // get group name from clicked item
	        var groupName = $(this).attr('data-group');

	        // reshuffle grid
	        $grid.shuffle('shuffle', groupName);
	    });


	}());

	$(document).ready(function () {
	    $(window).on('resize', function () {
	        parallax();
	    });

	    parallax();
	});

	function parallax() {
	    $('#twrap').parallax("50%", 0.4);
	    $('#wwrap').parallax("50%", 0.4);
	}
