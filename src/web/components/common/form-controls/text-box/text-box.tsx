import {
  type ChangeEvent,
  type FC,
  type KeyboardEvent,
  useCallback,
} from "react";
import styles from "./text-box.module.scss";
import cx from "classnames";

interface Props {
  className?: string;
  error?: boolean;
  value: string;
  placeholder?: string;

  onChange(_value: string): void;

  onPressEnter?(): void;
}

const TextBox: FC<Props> = (props) => {
  const onChange = useCallback((event: ChangeEvent<HTMLInputElement>) => {
    const newValue = event.target.value;
    props.onChange(newValue);
  }, []);

  const onKeyDown = useCallback(
    (event: KeyboardEvent<HTMLInputElement>) => {
      if (event.key === "Enter") {
        props.onPressEnter?.();
      }
    },
    [props.onPressEnter],
  );

  return (
    <input
      className={cx(props.className, styles.TextBox, {
        [styles.error]: props.error,
      })}
      placeholder={props.placeholder}
      value={props.value ?? ""}
      onChange={onChange}
      onKeyUp={onKeyDown}
    />
  );
};

export default TextBox;
