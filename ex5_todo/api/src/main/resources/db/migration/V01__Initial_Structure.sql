create table todo_item(
    id bigserial,
    description text not null,
    done boolean default FALSE
)