import { createAction, createAsyncThunk } from "@reduxjs/toolkit";
import type { AppDispatch, GetState, RootState } from "web/state/store";
import ConvertService from "@services/convert";

/*
Partition the 'setInputValue' action two separate 'public' and 'private' actions.
- The 'public' action is used by the display layer to interface (indirectly) with the store.
- The 'private' action is wrapped by the 'public' action and (in this case) only dispatched
when necessary.

In most cases this pattern is unnecessary, but it's an easy solution to keep the redux logs
clean when dispatching an action doesn't result in a state change. Additionally, it's not
meant to introduce or enforce access policies, only logical separation. The 'private' action
can still be used if needed.

This same logic can be implemented in the component, but this method makes it slightly easier
to leverage memoization to cut down on re-renders.
*/

// private
const _setInputValue = createAction<string>("convert/SET_INPUT_VALUE");

// public
const setInputValue =
  (newValue: string) => (dispatch: AppDispatch, getState: GetState) => {
    if (getState().convert.inputValue !== newValue) {
      dispatch(_setInputValue(newValue));
    }
  };

const resetResult = createAction("convert/RESET_RESULT");

const convertInputValue = createAsyncThunk<string, void, { state: RootState }>(
  "convert/CONVERT_INPUT_VALUE",
  async (_, { getState }) =>
    ConvertService.romanizeInteger(getState().convert.inputValue),
);

const ConvertActions = {
  setInputValue,
  resetResult,
  convertInputValue,

  // separate the 'private' actions from their 'public' partners
  private: {
    _setInputValue,
  },
};

export default ConvertActions;
