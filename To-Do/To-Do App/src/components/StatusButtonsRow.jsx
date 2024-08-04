import { HiMiniPlus } from "react-icons/hi2";
import { HiBars4 } from "react-icons/hi2";
import { useTasks } from "../utils/ContextApi";
import { useState } from "react";
import { deleteAllTask } from "../utils/service";
import { useMutation, useQueryClient } from "@tanstack/react-query";

function StatusButtonsRow() {
  const { setIsFormOpen } = useTasks();
  const [isOpen, setIsOpen] = useState(false);
  const queryClient = useQueryClient();

  function handleOpenForm() {
    setIsFormOpen((s) => !s);
  }

  async function handleDeleteAllTask() {
    await deleteAllTask();
    queryClient.invalidateQueries({
      queryKey: ["tasks"],
    });
    setIsOpen(false);
  }

  const { mutate } = useMutation({
    mutationFn: sortFunc,
    mutationKey: ["tasks"],
    onSuccess: (data) => {
      queryClient.setQueryData(["tasks"], data);
    },
  });

  async function handleSortFunc() {
    mutate();
    setIsOpen(false);
  }

  async function sortFunc() {
    const { data: taskArr } = queryClient.getQueryState(["tasks"]);
    const newTaskList = taskArr
      .slice()
      .filter((item) => item.statusName === "Not Started")
      .concat(taskArr.filter((t) => t.statusName === "In Progress"))
      .concat(taskArr.filter((t) => t.statusName === "Done"));
    return newTaskList;
  }

  return (
    <div className="btn__container">
      <button onClick={handleOpenForm} type="button" className="btn__add-task">
        <span className="icon">
          <HiMiniPlus className="icon--add" />
        </span>
        Add Task
      </button>
      <button className="btn__options" onClick={() => setIsOpen((s) => !s)}>
        <HiBars4 />
      </button>
      {isOpen && (
        <div className="btn__options--select">
          <button onClick={handleDeleteAllTask} className="bnt__option">
            Delete All
          </button>
          <button onClick={handleSortFunc} className="bnt__option">
            Sort Tasks
          </button>
        </div>
      )}
    </div>
  );
}

export default StatusButtonsRow;
