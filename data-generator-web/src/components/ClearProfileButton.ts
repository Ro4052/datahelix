import {connect} from "react-redux";
import {Dispatch} from "redux";

import {ClearCurrentProfile} from "../redux/actions/Actions";
import {Button, ButtonProps} from "semantic-ui-react";

function mapDispatchToProps(dispatch: Dispatch): ButtonProps
{
	return {
		onClick: () => {
			dispatch(ClearCurrentProfile.create({}));
		},
		content: "New Profile"
	};
}

const WrappedComponent = connect(undefined, mapDispatchToProps)(Button);

export default WrappedComponent;