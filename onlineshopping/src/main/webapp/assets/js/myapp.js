$(function(){
	//solving the active menu issue
	switch(menu) {
	
		case 'About Us':
			$('#about').addClass('active');
		break;
		case 'Contact Us':
			$('#contact').addClass('active');
		break;
		default:
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
		break;
	
	}
	
});