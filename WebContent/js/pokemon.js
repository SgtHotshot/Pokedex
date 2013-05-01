//init();

function loadPokemon(pokemonId){
	$.ajax({
		url: 'ContentDeliver',
		data: {
			ID: pokemonId
		},
		dataType: 'json',
		success: function(data) {
			if(data == ""){
				//do nothing
			}else{
				//modify gui values
			}
		}
		
	});
}

function loadPokemon(name){
	$.ajax({
		url: 'ContentDeliver',
		data: {
			Name: name
		},
		dataType: 'json',
		success: function(data) {
			if(data == ""){
				//do nothing
			}else{
				//modify gui values
				$("#name") // = id - name
				$("#species")
				$("#height")
				$("#weight")
				$("#type")
				$("#weakness")
				$("#image")
				
			}
		}
		
	});
}

/*
function init(){
	$.ajax({
		url: 'ContentDeliver',
		data: {
			ALL: "ALL"
		},
		dataType: 'json',
		success: function(data) {
			if(data == ""){
				//do nothing
			}else{
				// load list
			}
		}
		
	});
}
*/