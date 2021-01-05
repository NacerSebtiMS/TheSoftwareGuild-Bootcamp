$(document).ready(function(){
    
    // wire up the toggleNumbers button
    $('#toggleNumbers').on('click', function() {
       $('h2').toggle('slow'); 
    });
    
    // show that you can do more than one thing at a time in an event 
    // handler
    $('#centerUp').on('click', function() {
        $('h1').addClass('text-center');
        $('h2').addClass('text-center');
        $('#buttonDiv').addClass('text-center');
    });
    
    // just another example with styles
    $('#headingsBlue').on('click', function() {
        $('h1').css('color', 'blue');
    });    
})
