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
				$("#name").html(data.pokemonId + " - " + data.name); // = id - name
				$("#species").html(data.species);
				$("#height").html(data.height);
				$("#weight").html(data.weight);
				$("#type").html(data.type);
				$("#weakness").html(data.weakness);
				$("#image").attr('src',data.imageUrl);				
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