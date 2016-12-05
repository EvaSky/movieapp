CREATE OR REPLACE FUNCTION update_rating()
  RETURNS TRIGGER AS
$comments_update$
DECLARE
  count INTEGER;
BEGIN
  count := (SELECT COUNT(*) FROM comments WHERE comments.film_id=NEW.film_id AND comments.status='checked');
  IF (NEW.status = 'checked') THEN
    UPDATE films SET rating = ((NEW.mark + rating*(count-1))/count) WHERE id = NEW.film_id;
  END IF;
END;
RETURN NEW;
$comments_update$ LANGUAGE plpgsql;