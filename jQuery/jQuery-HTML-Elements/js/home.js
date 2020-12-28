$(document).ready(function () {

  //    Center all H1 elements.

  $('H1').addClass('text-center');

  //    Center all H2 elements.

  $('H2').addClass('text-center');

  //    Replace the class that is on the element containing the text "Team Up!" with the class page-header.

  $('.myBannerHeading').addClass('page-header');
  $('.myBannerHeading').removeClass('myBannerHeading');

  //    Change the text of "The Squad" to "Yellow Team".

  $('#yellowHeading').text("Yellow Team")

  //    Change the background color for each team list to match the name of the team.

  $('#orangeTeamList').css("background-color", "orange");
  $('#blueTeamList').css("background-color", "blue");
  $('#redTeamList').css("background-color", "red");
  $('#yellowTeamList').css("background-color", "yellow");

  //    Add Joseph Banks and Simon Jones to the Yellow Team list.

  $('#yellowTeamList').append("<li>Joseph Banks</li>");
  $('#yellowTeamList').append("<li>Simon Jones</li>");

  //    Hide the element containing the text "Hide Me!!!"

  $('#oops').hide();

  //    Remove the element containing the text "Bogus Contact Info" from the footer.

  $('#footerPlaceholder').remove();

  //    Add a paragraph element containing your name and email to the footer. The text must be in Courier font and be 24 pixels in height.

  $('#footer').append("<p id='customFooter'>Nacer : my@email.com</p>");
  $('#customFooter').css('font-family', 'Courier');
  $('#customFooter').css('font-size', '24px');

});
