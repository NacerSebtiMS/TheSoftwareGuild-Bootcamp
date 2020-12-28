$(document).ready(function () {
//    ===Page Load===

//        Only the content in the Main section should display when the page is loaded.
  $('#mainInfoDiv').show();
  $('#akronInfoDiv').hide();
  $('#minneapolisInfoDiv').hide();
  $('#louisvilleInfoDiv').hide();

  $('#mainButton').on('click', function() {
    $('#mainInfoDiv').show();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
  });


//    ===Navigation Button Behavior===

//        When the Akron button is clicked, only the content in the Akron section should display; the weather information for Akron should be hidden initially.
  $('#akronButton').on('click', function() {
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').show();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
  });


//        When the Minneapolis button is clicked, only the content in the Minneapolis section should display; the weather information for Minneapolis should be hidden initially.
  $('#minneapolisButton').on('click', function() {
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').show();
    $('#louisvilleInfoDiv').hide();
  });

//        When the Louisville button is clicked, only the content in the Louisville section should display; the weather information for Louisville should be hidden initially.
  $('#louisvilleButton').on('click', function() {
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').show();
  });

//    ===Show/Hide Weather Behavior===

//        When the Show/Hide Weather button is clicked, the page should display the associated weather information if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
  $('#akronWeather').hide();
  $('#akronWeatherButton').on('click', function() {
    $('#akronWeather').toggle('show');
  });

  $('#minneapolisWeather').hide();
  $('#minneapolisWeatherButton').on('click', function() {
    $('#minneapolisWeather').toggle('show');
  });

  $('#louisvilleWeather').hide();
  $('#louisvilleWeatherButton').on('click', function() {
    $('#louisvilleWeather').toggle('show');
  });

//    ===Table Row Behavior===

//        The background color of any table row should change to “WhiteSmoke” when the mouse pointer is hovering over the row.
//        The background color of the row should return to white when the mouse pointer is no longer hovering over the row.
//        This applies to all rows in all tables except the first (header) row in a given table. The first (header) row in any table should not change appearance when the mouse pointer hovers over it.

  $('td').parent().hover(
    // in callback
    function() {
        $(this).css('background-color', 'WhiteSmoke');
    },
    // out callback
    function() {
        $(this).css('background-color', '');
    });


});
