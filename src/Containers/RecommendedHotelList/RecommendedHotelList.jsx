import React from "react";
import "./RecommendedHotelList.css";
import HotelTable from "../../Components/HotelTable/HotelTable";

class RecommendedHotelList extends React.Component {
	render() {
		return (
			<div className="hotel-recommendations">
				<HotelTable />
				<p>Łączna kwota: $milion</p>
				<button>Przejdź dalej</button>
			</div>
		);
	}
}

export default RecommendedHotelList;
