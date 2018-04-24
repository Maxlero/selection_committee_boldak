jQuery(function ($) {
	var currentMousePos = {x: -1, y: -1};
	var eyes = $('#max-eyes');
	var offset = eyes.offset();

	$(document).mousemove(function (event) {
		currentMousePos.x = event.pageX;
		currentMousePos.y = event.pageY;

		moveEyes();
	});

	$(window).resize(function () {
		offset = eyes.offset();
	});

	function moveEyes() {
		var posX = (currentMousePos.x - offset.left - eyes.width() / 2) / 400;
		var posY = (currentMousePos.y - offset.top - eyes.height() / 2) / 400;

		if (posX > 1.0)
			posX = 1.0;

		if (posX < -1.0)
			posX = -1.0;

		if (posY > 1.0)
			posY = 1.0;

		if (posY < -1.0)
			posY = -1.0;

		eyes.css({
			'-webkit-transform' : 'translateX(' + 6 * posX + 'px) translateY(' + (4 * posY - 2) + 'px)',
			'-moz-transform'    : 'translateX(' + 6 * posX + 'px) translateY(' + (4 * posY - 2) + 'px)',
			'-ms-transform'     : 'translateX(' + 6 * posX + 'px) translateY(' + (4 * posY - 2) + 'px)',
			'-o-transform'      : 'translateX(' + 6 * posX + 'px) translateY(' + (4 * posY - 2) + 'px)',
			'transform'         : 'translateX(' + 6 * posX + 'px) translateY(' + (4 * posY - 2) + 'px)'
		});
		// console.log(6 * posX);
		// console.log(7 * posY);
	}
});