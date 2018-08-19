function openHeadlineModal(counter){
  			$.ajax({
   				url: "/headline/" + counter,
   				success: function(data){
   					$("#headlineModalHolder").html(data);
   					$('#headlineModal').modal({
                       	backdrop: 'static'
                   	});
   				}
   			});
   		}
function searchHeadline(co,ca){
            var co = document.getElementById("country");
            var strCountry = co.options[co.selectedIndex].text;
            var ca = document.getElementById("category");
            var strCategory = ca.options[ca.selectedIndex].text;
            var url = "http://localhost:8080/?country="+strCountry+"&category="+strCategory;
              window.open(url,'_self');
   		}