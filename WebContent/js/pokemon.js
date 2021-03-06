loadPokemonByName("Bulbasaur");

function loadPokemonById(pokemonId){
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

function loadPokemonByName(name){
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

function search(){
	var searchName = $("#search-box").val();
	if(searchName != ''){
		loadPokemonByName(searchName);
	}
}

function enterPressed(){
	if(event.keyCode == 13){
		search();
	}
}