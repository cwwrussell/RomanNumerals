import { createReducer } from "@reduxjs/toolkit";
import ConvertActions from "@state/convert/actions";
import type ServicePayload from "@models/service-payload";

export interface State {
  converting: boolean;
  inputValue: string;
  result: ServicePayload<string>;
}

const INITIAL_STATE: State = {
  converting: false,
  inputValue: "",
  result: undefined,
};

const reducer = createReducer(INITIAL_STATE, (convert) => {
  // /////////////////////
  // SYNCHRONOUS ACTIONS
  // /////////////////////
  convert.addCase(
    ConvertActions.private._setInputValue,
    (state, { payload }) => {
      state.inputValue = payload;
    },
  );

  // /////////////////////
  // ASYNCHRONOUS ACTIONS
  // /////////////////////
  convert
    .addCase(ConvertActions.convertInputValue.pending, (state) => {
      state.converting = true;
    })
    .addCase(
      ConvertActions.convertInputValue.fulfilled,
      (state, { payload }) => ({
        ...state,
        converting: false,
        result: payload,
      }),
    )
    .addCase(ConvertActions.convertInputValue.rejected, (state) => ({
      ...state,
      converting: false,
      result: null,
    }));

  // default
  convert.addDefaultCase((state) => state);
});

export default reducer;
