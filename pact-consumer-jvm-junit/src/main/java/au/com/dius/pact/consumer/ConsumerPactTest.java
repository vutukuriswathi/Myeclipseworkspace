package au.com.dius.pact.consumer;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.MockProviderConfig$;
import au.com.dius.pact.model.PactConfig;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.PactSpecVersion;
import org.junit.Test;

import java.io.IOException;

public abstract class ConsumerPactTest {
    public static VerificationResult PACT_VERIFIED = PactVerified$.MODULE$;

    protected abstract PactFragment createFragment(PactDslWithProvider builder);
    protected abstract String providerName();
    protected abstract String consumerName();

    protected abstract void runTest(String url) throws IOException;

    @Test
    public void testPact() throws Throwable {
        PactFragment fragment = createFragment(ConsumerPactBuilder.consumer(consumerName()).hasPactWith(providerName()));
        final MockProviderConfig config = MockProviderConfig$.MODULE$.createDefault(PactConfig.apply(getSpecificationVersion()));

        VerificationResult result = fragment.runConsumer(config, new TestRun() {
            public void run(MockProviderConfig config) throws IOException {
                runTest(config.url());
            }
        });

        if (!result.equals(PACT_VERIFIED)) {
            if (result instanceof PactError) {
                throw ((PactError)result).error();
            }
            if (result instanceof UserCodeFailed) {
                throw ((UserCodeFailed<RuntimeException>)result).error();
            }
            if (result instanceof PactMismatch) {
                PactMismatch mismatch = (PactMismatch) result;
                throw new PactMismatchException(mismatch);
            }
        }
    }

    protected PactSpecVersion getSpecificationVersion() {
        return PactSpecVersion.V2;
    }

}
