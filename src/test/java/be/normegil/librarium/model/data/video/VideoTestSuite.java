package be.normegil.librarium.model.data.video;

import be.normegil.librarium.WarningTypes;
import be.normegil.librarium.model.data.Media;
import be.normegil.librarium.model.data.fake.FakeVideo;
import be.normegil.librarium.model.data.people.Responsible;
import be.normegil.librarium.model.data.people.Role;
import be.normegil.librarium.tool.DataFactory;
import be.normegil.librarium.tool.FactoryRepository;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.time.Duration;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		UTVideoSafety.class,
		UTVideo.class,
		UTVideoEquality.class,
		UTVideoComparator.class,
		UTVideoBuilderSafety.class,
		UTVideoBuilder.class,
})
public class VideoTestSuite implements DataFactory<Video> {

	@SuppressWarnings(WarningTypes.UNCHECKED_CAST)
	private static final DataFactory<Media> MEDIA_FACTORY = FactoryRepository.get(Media.class);
	@SuppressWarnings(WarningTypes.UNCHECKED_CAST)
	private static final DataFactory<Role> ROLE_FACTORY = FactoryRepository.get(Role.class);
	@SuppressWarnings(WarningTypes.UNCHECKED_CAST)
	private static final DataFactory<Responsible> RESPONSIBLE_FACTORY = FactoryRepository.get(Responsible.class);
	private static long index = 0L;

	@Override
	public Video getDefault() {
		return getDefault(true);
	}

	@Override
	public Video getNew() {
		return getNew(true);
	}

	@Override
	public Video getDefault(boolean withLink) {
		FakeVideo.Builder builder = FakeVideo.builder()
				.from(MEDIA_FACTORY.getDefault(withLink))
				.setDuration(Duration.ofMinutes(90));
		if (withLink) {
			builder.addActor(ROLE_FACTORY.getDefault(false))
					.addProducer(RESPONSIBLE_FACTORY.getDefault(false))
					.addDirector(RESPONSIBLE_FACTORY.getDefault(false))
					.addComposer(RESPONSIBLE_FACTORY.getDefault(false))
					.addScenarist(RESPONSIBLE_FACTORY.getDefault(false))
					.addOtherStaffMember(RESPONSIBLE_FACTORY.getDefault(false));
		}

		return builder.build();
	}

	@Override
	public Video getNew(boolean withLink) {
		FakeVideo.Builder builder = FakeVideo.builder()
				.from(MEDIA_FACTORY.getNew(withLink))
				.setDuration(Duration.ofMinutes(index));

		if (withLink) {
			builder.addActor(ROLE_FACTORY.getNew(false))
					.addProducer(RESPONSIBLE_FACTORY.getNew(false))
					.addProducer(RESPONSIBLE_FACTORY.getNew(false))
					.addDirector(RESPONSIBLE_FACTORY.getNew(false))
					.addDirector(RESPONSIBLE_FACTORY.getNew(false))
					.addComposer(RESPONSIBLE_FACTORY.getNew(false))
					.addComposer(RESPONSIBLE_FACTORY.getNew(false))
					.addScenarist(RESPONSIBLE_FACTORY.getNew(false))
					.addScenarist(RESPONSIBLE_FACTORY.getNew(false))
					.addOtherStaffMember(RESPONSIBLE_FACTORY.getNew(false))
					.addOtherStaffMember(RESPONSIBLE_FACTORY.getNew(false));
		}

		index += 1;
		return builder.build();
	}
}