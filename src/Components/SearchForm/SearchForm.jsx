import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";
import PersonCounter from "../../Components/PersonCounter/PersonCounter";

function SearchForm(props) {
	return (
		<form className="home-form">
			<h3 className="home-form-heading">
				1. Wybierz termin który Cię interesuje
			</h3>
			<input type="date" placeholder="Data przyjazdu" />
			<input type="date" placeholder="Data wyjazdu" />
			<h3 className="home-form-heading">2. Wybierz liczbę osób</h3>
			<p>
				(W przypadku większej liczby osób proszę wybrać więcej niz jedną
				opcję)
			</p>
			<PersonCounter
				options={props.options}
				handler={props.chooseRoomOptionHandler}
			/>
			<button>
				<FontAwesomeIcon style={{ marginRight: 10 }} icon={faSearch} />
				Szukaj
			</button>
		</form>
	);
}

export default SearchForm;
