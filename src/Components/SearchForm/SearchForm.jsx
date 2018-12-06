import React from "react";
import PersonCounter from "../../Components/PersonCounter/PersonCounter";
import "./SearchForm.css";

function SearchForm(props) {
	return (
		<React.Fragment>
			<h3 className="home-form-heading">
				1. Wybierz termin który Cię interesuje
			</h3>
			<form className="home-form">
				<input type="date" placeholder="Data przyjazdu" />
				<input type="date" placeholder="Data wyjazdu" />
				<div>
					<h3 className="home-form-heading">
						2. Wybierz liczbę osób
					</h3>
					<PersonCounter
						options={props.options}
						handler={props.chooseRoomOptionHandler}
					/>
				</div>
			</form>
			<button className="home-form-button">Szukaj</button>
		</React.Fragment>
	);
}

export default SearchForm;
